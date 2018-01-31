import com.example.GradeConverter;
import com.example.GradeDisplay;
import com.example.MyGradeController;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class MyGradeControllerTest {


    private GradeDisplay mockedDisplay;
    private MyGradeController controller;
    private GradeConverter mockedConverter;

    @Before
    public void setUp() throws Exception {
        mockedDisplay = Mockito.mock(GradeDisplay.class);
        mockedConverter = Mockito.mock(GradeConverter.class);

        controller = new MyGradeController(mockedDisplay);
        controller.setGradeConverter(mockedConverter);
    }

    @Test
    public void onSubmit_should_call_getScore_from_activity(){
        controller.onSubmit();

        Mockito.verify(mockedDisplay).getScore();
    }

    @Test
    public void onSubmit_should_call_fromScore_on_gradeConverter(){
        int expectedScore = 0;
        Mockito.when(mockedDisplay.getScore()).thenReturn(expectedScore);

        controller.onSubmit();

        Mockito.verify(mockedConverter).fromScore(expectedScore);
    }

    @Test
    public void onSubmit_should_call_setGrade_on_gradeDisplay_with_converted_grade() {
        String convertedGrade = "A";
        Mockito.when(mockedConverter.fromScore(Mockito.anyInt())).thenReturn(convertedGrade);

        controller.onSubmit();

        Mockito.verify(mockedDisplay).setGrade(convertedGrade);
    }
}
