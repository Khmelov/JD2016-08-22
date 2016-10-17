package by.it.aborisenok.JD02_09.TaskB;



import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by Лёша on 16.10.2016.
 */
public class ToXML {
    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Ticket.class);
            Marshaller m = context.createMarshaller();
            Ticket st = new Ticket();

                Policlinic policlinic = new Policlinic();
                policlinic.setNumber("12 policlinik");
                Doctor doctor = new Doctor();
                doctor.setPost("cardiologist");
                doctor.setDoctorName("Martin");
                doctor.setDoctorSurname("Jonson");
                doctor.setCategory("first");
                doctor.setCabinet(454);
                policlinic.setDoctor(doctor);

                st.setPoliclinic(policlinic);

                VisitDate visitDate = new VisitDate();
                XMLGregorianCalendar calendar = new XMLGregorianCalendarImpl();
                calendar.setYear(1956);
                calendar.setMonth(12);
                calendar.setDay(13);
                visitDate.setDate(calendar);
                visitDate.setTime("12:34");

                st.setVisitDate(visitDate);

                Patient patient = new Patient();
                patient.setPatientName("Tom");
                patient.setPatientSurname("Hakins");
                XMLGregorianCalendar birthday = new XMLGregorianCalendarImpl();
                birthday.setYear(1992);
                birthday.setMonth(9);
                birthday.setDay(10);
                patient.setBirthDay(birthday);
                Address address = new Address();
                address.setCity("Minsk");
                address.setStreet("Nezavisimosti");
                address.setHouse(123);
                address.setRoom(12);
                patient.setAddress(address);

                st.setPatient(patient);

            m.marshal(st, new FileOutputStream("src/by/it/aborisenok/jd02_09/TaskB/XML+XSD.xml"));
            System.out.println("XML-файл создан");
            m.marshal(st, System.out);
        } catch (FileNotFoundException e) {
            System.out.println("XML-файл не может быть создан: " + e);
        }
        catch (JAXBException e) {
            System.out.println("JAXB-контекст ошибочен " + e);
        }
    }
}
