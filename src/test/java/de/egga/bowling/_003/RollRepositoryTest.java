package de.egga.bowling._003;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RollRepositoryTest {

    @Mock FrameMapper mapper;

    @InjectMocks RollRepository repository;

    @Test
    public void itName() {
        repository.save(1);
    }
}