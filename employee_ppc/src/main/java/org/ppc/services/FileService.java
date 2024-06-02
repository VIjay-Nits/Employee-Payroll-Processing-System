package org.ppc.services;

import org.ppc.dto.EventDTO;

import java.util.List;

public interface FileService {

    void processEventList(List<EventDTO> eventDTO, String fileName);
}
