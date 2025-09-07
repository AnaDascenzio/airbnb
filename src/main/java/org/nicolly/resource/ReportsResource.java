package org.nicolly.resource;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nicolly.model.entity.Airbnb;
import org.nicolly.repository.dao.AirbnbDao;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Path("/relatorio")
public class ReportsResource {

    @Inject
    AirbnbDao airbnbDao;

    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response gerarRelatorio() {
        try {
            // 1. Carregar template .jasper (pré-compilado)
            InputStream relatorioStream = getClass()
                .getResourceAsStream("/reports/airbnbReport/airbnb.jasper");

            // 2. Buscar dados da API/DB
            List<Airbnb> dados = airbnbDao.listAll();

            // 3. Converter para datasource Jasper
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dados);

            // 4. Preencher relatório
            Map<String, Object> parametros = new HashMap<>();
            JasperPrint print = JasperFillManager.fillReport(relatorioStream, parametros, dataSource);

            // 5. Exportar para PDF em memória
            byte[] pdf = JasperExportManager.exportReportToPdf(print);

            // 6. Retornar como download
            return Response.ok(pdf)
                    .header("Content-Disposition", "attachment; filename=relatorio-airbnb.pdf")
                    .build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError()
                    .entity("Erro ao gerar relatório: " + e.getMessage())
                    .build();
        }
    }
}