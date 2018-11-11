package com.chamado.relatorio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Rodrigo
 */
public class Relatorio {

    private HttpServletResponse response;
    private FacesContext context;
    private ByteArrayOutputStream arrayOutputStream;
    private InputStream inputStream;

    public Relatorio() {
        this.context = FacesContext.getCurrentInstance();
        this.response = (HttpServletResponse) context.getExternalContext().getResponse();
    }

    public void getRelatorio(List<?> lista, String caminho) {
        inputStream = this.getClass().getResourceAsStream(caminho);
        Map<String, Object> params = new HashMap<String, Object>();
        arrayOutputStream = new ByteArrayOutputStream();

        try {
            JasperReport report = (JasperReport) JRLoader.loadObject(inputStream);
            JasperPrint print = JasperFillManager.fillReport(report, params, new JRBeanCollectionDataSource(lista));

            JasperExportManager.exportReportToPdfStream(print, arrayOutputStream);

            response.reset();
            response.setContentType("application/pdf");
            response.setContentLength(arrayOutputStream.size());
            response.setHeader("Content-disposition", "inline; filename=relatorio.pdf");

            try {
                response.getOutputStream().write(arrayOutputStream.toByteArray());
                response.getOutputStream().flush();
                response.getOutputStream().close();
            } catch (IOException ex) {
                Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
            }

            context.responseComplete();

        } catch (JRException ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
