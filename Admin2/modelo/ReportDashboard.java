package org.ga.Admin2.modelo;

import org.openxava.annotations.*;
import org.openxava.jpa.XPersistence;

import javax.persistence.*;
import java.util.List;

@View(members =
        "estadisticas[" +
                "totalEstudiantesEnviados, totalEstudiantesRecibidos, totalEstudiantesVirtual;" +
                "totalDocentesEnviados, totalDocentesRecibidos, totalDocentesVirtual;" +
                "totalEventosRealizados" +
                "];" +
                "detalles[" +
                "desafios, oportunidades, estrategiasFuturas, necesidades, recomendaciones" +
                "]")
public class ReportDashboard {

    /** Total de estudiantes enviados */
    @LargeDisplay(icon = "account")
    public String getTotalEstudiantesEnviados() {
        Long total = (Long) XPersistence.getManager()
                .createQuery("select sum(r.sentStudents) from ReportDetail r")
                .getSingleResult();
        return "<strong>Estudiantes enviados:</strong> " + (total != null ? total : 0);
    }

    /** Total de estudiantes recibidos */
    @LargeDisplay(icon = "account-multiple")
    public String getTotalEstudiantesRecibidos() {
        Long total = (Long) XPersistence.getManager()
                .createQuery("select sum(r.receivedStudents) from ReportDetail r")
                .getSingleResult();
        return "<strong>Estudiantes recibidos:</strong> " + (total != null ? total : 0);
    }

    /** Total de estudiantes en modalidad virtual */
    @LargeDisplay(icon = "desktop-mac")
    public String getTotalEstudiantesVirtual() {
        Long total = (Long) XPersistence.getManager()
                .createQuery("select sum(r.virtualModeStudents) from ReportDetail r")
                .getSingleResult();
        return "<strong>Estudiantes en modalidad virtual:</strong> " + (total != null ? total : 0);
    }

    /** Total de docentes enviados */
    @LargeDisplay(icon = "account-tie")
    public String getTotalDocentesEnviados() {
        Long total = (Long) XPersistence.getManager()
                .createQuery("select sum(r.sentTeachers) from ReportDetail r")
                .getSingleResult();
        return "<strong>Docentes enviados:</strong> " + (total != null ? total : 0);
    }

    /** Total de docentes recibidos */
    @LargeDisplay(icon = "account-group")
    public String getTotalDocentesRecibidos() {
        Long total = (Long) XPersistence.getManager()
                .createQuery("select sum(r.receivedTeachers) from ReportDetail r")
                .getSingleResult();
        return "<strong>Docentes recibidos:</strong> " + (total != null ? total : 0);
    }

    /** Total de docentes en modalidad virtual */
    @LargeDisplay(icon = "laptop")
    public String getTotalDocentesVirtual() {
        Long total = (Long) XPersistence.getManager()
                .createQuery("select sum(r.virtualModeTeachers) from ReportDetail r")
                .getSingleResult();
        return "<strong>Docentes en modalidad virtual:</strong> " + (total != null ? total : 0);
    }

    /** Total de eventos realizados */
    @LargeDisplay(icon = "calendar-check")
    public String getTotalEventosRealizados() {
        Long total = (Long) XPersistence.getManager()
                .createQuery("select sum(r.events) from ReportDetail r")
                .getSingleResult();
        return "<strong>Eventos realizados:</strong> " + (total != null ? total : 0);
    }

    /** Desafíos encontrados */
    @Stereotype("MEMO")
    public String getDesafios() {
        List<String> desafios = XPersistence.getManager()
                .createQuery("select r.challenges from ReportDetail r", String.class)
                .getResultList();
        return String.join(", ", desafios);
    }

    /** Oportunidades encontradas */
    @Stereotype("MEMO")
    public String getOportunidades() {
        List<String> oportunidades = XPersistence.getManager()
                .createQuery("select r.opportunities from ReportDetail r", String.class)
                .getResultList();
        return String.join(", ", oportunidades);
    }

    /** Estrategias futuras */
    @Stereotype("MEMO")
    public String getEstrategiasFuturas() {
        List<String> estrategias = XPersistence.getManager()
                .createQuery("select r.futureStrategies from ReportDetail r", String.class)
                .getResultList();
        return String.join(", ", estrategias);
    }

    /** Necesidades futuras */
    @Stereotype("MEMO")
    public String getNecesidades() {
        List<String> necesidades = XPersistence.getManager()
                .createQuery("select r.necessities from ReportDetail r", String.class)
                .getResultList();
        return String.join(", ", necesidades);
    }

    /** Recomendaciones */
    @Stereotype("MEMO")
    public String getRecomendaciones() {
        List<String> recomendaciones = XPersistence.getManager()
                .createQuery("select r.suggestions from ReportDetail r", String.class)
                .getResultList();
        return String.join(", ", recomendaciones);
    }
}

