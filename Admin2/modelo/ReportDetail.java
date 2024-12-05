package org.ga.Admin2.modelo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import org.openxava.annotations.Hidden;
import org.openxava.annotations.Required;
import org.openxava.annotations.Stereotype;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ReportDetail {
    @Id
    @Hidden
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")


    private String oid;



    @Column(length = 60)
    @Stereotype("TEXT")
    @Required(message = "Ingrese el nombre de la facultad.")
    private String titleFaculty;

    @Required(message = "Debe ingresar el numero de estudiantes enviados.")
    private int sentStudents;

    @Required(message = "Debe ingresar el n?mero de estudiantes recibidos.")
    private int receivedStudents;

    @Required(message = "Debe ingresar el n?mero de estudiantes en modalidad virtual.")
    private int virtualModeStudents;

    @Required(message = "Debe ingresar el n?mero de docentes enviados.")
    private int sentTeachers;

    @Required(message = "Debe ingresar el n?mero de docentes recibidos.")
    private int receivedTeachers;

    @Required(message = "Debe ingresar el n?mero de docentes en modalidad virtual.")
    private int virtualModeTeachers;

    @Required(message = "Debe ingresar n?mero de eventos realizados.")
    private int events;

    @Column(length = 200)
    @Required(message = "Debe ingresar los desaf?os encontrados durante las actividades.")
    private String challenges;

    @Column(length = 200)
    @Required(message = "Debe ingresar las oportunidades encontradas durante las actividades.")
    private String opportunities;

    @Column(length = 200)
    @Required(message = "Debe ingresar las estrategias para futuras actividades.")
    private String futureStrategies;

    @Column(length = 200)
    @Required(message = "Debe ingresar las necesidades para futuras actividades.")
    private String necessities;

    @Column(length = 200)
    @Required(message = "Debe ingresar las recomendaciones para futuras actividades.")
    private String suggestions;

    @OneToOne Faculty faculty;



}
