package com.weg.reenginered.application.usecase.local;

import com.weg.reenginered.domain.entity.Local;
import com.weg.reenginered.domain.port.LocalPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveLocalUseCase {
    private final LocalPort localPort;

    public Local execute(Local local){
        return localPort.save(local);
    }
}
