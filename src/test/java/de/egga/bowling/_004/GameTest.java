package de.egga.bowling._004;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    @Mock ScoreService scoreService;
    @Mock FrameService frameService;

    @InjectMocks Game game;

    @Test
    public void it_should_call_score_service() {
        game.score();
        verify(scoreService).calculateScore();
    }

    @Test
    public void it_should_call_frame_service() {
        game.roll(1);
        verify(frameService).addRoll(1);
    }
}
