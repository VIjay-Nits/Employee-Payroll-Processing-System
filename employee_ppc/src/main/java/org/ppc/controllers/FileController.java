package org.ppc.controllers;


import org.ppc.dto.EventDTO;
import org.ppc.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    FileService fileService;

    @PostMapping("/upload")
    public void processCsv(@RequestBody MultipartFile file) throws IOException {
        List<EventDTO> eventList = new ArrayList<>();
        String fileName = file.getOriginalFilename();
        int startIndex = fileName.replaceAll("\\\\", "/").lastIndexOf("/");
        String inputFileName = fileName.substring(startIndex + 1);
        System.out.println(inputFileName);

        BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
        String line;

        System.out.printf(inputFileName);
        while ((line = reader.readLine()) != null) {
           // System.out.println(line);
            String[] data = line.split(",");
            EventDTO eventDTO = new EventDTO();
            //System.out.println(data);

            if(data.length == 6){
                eventDTO.setId(Integer.parseInt(data[0].trim()));
                eventDTO.setEmpId(data[1].trim());
                eventDTO.setEvent(data[2].trim());
                eventDTO.setValue(data[3].trim());
                eventDTO.setEventDate(data[4].trim());
                eventDTO.setNote(data[5].trim());


            }else{
                //ONBOARD Event
                eventDTO.setId(Integer.parseInt(data[0].trim()));
                eventDTO.setEmpId(data[1].trim());
                eventDTO.setFirstName(data[2].trim());
                eventDTO.setLastName(data[3].trim());
                eventDTO.setDesignation(data[4].trim());
                eventDTO.setEvent(data[5].trim());
                eventDTO.setValue(data[6].trim());
                eventDTO.setEventDate(data[7].trim());
                eventDTO.setNote(data[8].trim());

            }
            eventList.add(eventDTO);

        }

        // Process the list of EmployeeDTOs as required
        fileService.processEventList(eventList,inputFileName);
    }
}
