package org.ppc.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.ppc.dto.EventDTO;
import org.ppc.entities.Employee;
import org.ppc.entities.EventEmployee;
import org.ppc.entities.Orgnisation;
import org.ppc.repositories.EventEmployeeRepository;
import org.ppc.services.EmployeeService;
import org.ppc.services.OrgnisationService;
import org.ppc.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    OrgnisationService orgnisationService;

    @Autowired
    EventEmployeeRepository eventEmployeeRepository;

    @Override
    public void processEventList(List<EventDTO> eventList, String fileName) {

        String[] fileNameSplit = fileName.split("\\.");
        System.out.println(fileNameSplit.length);

        Optional<Orgnisation> org = orgnisationService.getOrgByName(fileNameSplit[0]);

        if(org.isEmpty()){
            log.error("Orgnisation with name:"+ fileNameSplit[0]+" not exist.....make sure imput filename is the orgnisation name");
            return;
        }

        for (EventDTO eventDTO : eventList) {
            try{
                String empId = eventDTO.getEmpId();
                Optional<Employee> e = employeeService.getEmployeeByEmpId(empId);

                boolean isEmployeeExist = !e.isEmpty();

                if(isEmployeeExist && eventDTO.getEvent().equals("ONBOARD")){
                    log.error("Employee with Emp ID: " + eventDTO.getEmpId() + " is already present");
                    continue;
                } else if (!(isEmployeeExist) && !(eventDTO.getEvent().equals("ONBOARD"))) {
                    log.error("Employee with Emp ID: " + eventDTO.getEmpId() + " is not present for event:" + eventDTO.getEvent());
                    continue;
                } else if (!(isEmployeeExist) && (eventDTO.getEvent().equals("ONBOARD"))) {

                    Employee ee = employeeService.add(eventDTO.getEmpId(),eventDTO.getFirstName(),eventDTO.getLastName(),eventDTO.getDesignation(),org.get());
                    e = employeeService.getEmployeeByEmpId(eventDTO.getEmpId());
                    addEmpEvent(e.get(),eventDTO);
                }else{

                    addEmpEvent(e.get(),eventDTO);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(eventDTO.toString());
        }
        return;
    }

    @Transactional(readOnly = false)
    private void addEmpEvent(Employee e,EventDTO eventDTO){
        if (eventDTO.getEventObj()==null){
            log.error("Invalid Event:"+eventDTO.getEvent());
            return;
        }
        try{
            EventEmployee eventEmployee = new EventEmployee();
            eventEmployee.setEmp(e);
            eventEmployee.setEvent(eventDTO.getEventObj());

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            java.util.Date utilDate = dateFormat.parse(eventDTO.getEventDate());
            Date sqlDate = new Date(utilDate.getTime());
            eventEmployee.setEventDate(sqlDate);

            eventEmployee.setEventNote(eventDTO.getNote());
            eventEmployee.setValue(eventDTO.getValue());
            eventEmployeeRepository.save(eventEmployee);
        }catch (Exception exp){
            exp.printStackTrace();
        }

    }
}
