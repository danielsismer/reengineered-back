package com.weg.reenginered.application.usecase.local;

import com.weg.reenginered.domain.port.LocalPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteLocalUseCase {

    private final LocalPort localPort;

    public void execute(Long id){
        localPort.deleteById(id);
    }
}
