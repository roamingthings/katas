package de.egga.bowling._003;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    @Mock RollRepository rollRepository;

    @InjectMocks Game game;


    @Test
    public void a_roll_should_be_saved_in_repository() {
        game.roll(3);
        verify(rollRepository).save(3);
    }

    @Test
    public void number_of_pins_should_be_calculated_from_repository() {
        when(rollRepository.getSum()).thenReturn(25);
        assertThat(game.score()).isEqualTo(25);
    }
}
