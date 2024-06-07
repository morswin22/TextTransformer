package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
class TextTransformerServiceTest {
    @Test
    public void testTransform() {
        NumberTransformer mockNumber = mock(NumberTransformer.class);
        TextTransformerService mockService = mock(TextTransformerService.class);
        List<String> operations = new ArrayList<>();
        operations.add("number");
        when(mockNumber.transform("12")).thenReturn("twelve");
        when(mockService.transform(anyString(), eq(operations))).thenAnswer(
                new Answer() {
                    public Object answer(InvocationOnMock invocationOnMock) {
                        Object[] args = invocationOnMock.getArguments();
                        Object mock = invocationOnMock.getMock();
                        return mockNumber.transform(args[0].toString());
                    }
        });
        Assertions.assertEquals("twelve", mockService.transform("12", operations));
        verify(mockService, times(1)).transform("12", operations);
        verify(mockNumber, times(1)).transform("12");
    }
    @Test
    public void testUppercase() {
        UppercaseTransformer mockUppercase = mock(UppercaseTransformer.class);
        TextTransformerService mockService = mock(TextTransformerService.class);
        List<String> operations = new ArrayList<>();
        operations.add("upper");
        when(mockUppercase.transform("okay")).thenReturn("OKAY");
        when(mockService.transform(anyString(), eq(operations))).thenAnswer(
                new Answer() {
                    public Object answer(InvocationOnMock invocationOnMock) {
                        Object[] args = invocationOnMock.getArguments();
                        Object mock = invocationOnMock.getMock();
                        return mockUppercase.transform(args[0].toString());
                    }
                });
        Assertions.assertEquals("OKAY", mockService.transform("okay", operations));
        verify(mockService, times(1)).transform("okay", operations);
        verify(mockUppercase, times(1)).transform("okay");
    }
    @Test
    public void testCapitalize() {
        CapitalizeTransformer mockCapitalize = mock(CapitalizeTransformer.class);
        TextTransformerService mockService = mock(TextTransformerService.class);
        List<String> operations = new ArrayList<>();
        operations.add("capitalize");
        when(mockCapitalize.transform("okay")).thenReturn("Okay");
        when(mockService.transform(anyString(), eq(operations))).thenAnswer(
                new Answer() {
                    public Object answer(InvocationOnMock invocationOnMock) {
                        Object[] args = invocationOnMock.getArguments();
                        Object mock = invocationOnMock.getMock();
                        return mockCapitalize.transform(args[0].toString());
                    }
                });
        Assertions.assertEquals("Okay", mockService.transform("okay", operations));
        verify(mockCapitalize, times(1)).transform("okay");
        verify(mockService, times(1)).transform("okay", operations);
    }
    @Test
    public void testLowercase() {
        LowercaseTransformer mockLowercase = mock(LowercaseTransformer.class);
        TextTransformerService mockService = mock(TextTransformerService.class);
        List<String> operations = new ArrayList<>();
        operations.add("upper");
        when(mockLowercase.transform("OKAY")).thenReturn("okay");
        when(mockService.transform(anyString(), eq(operations))).thenAnswer(
                new Answer() {
                    public Object answer(InvocationOnMock invocationOnMock) {
                        Object[] args = invocationOnMock.getArguments();
                        Object mock = invocationOnMock.getMock();
                        return mockLowercase.transform(args[0].toString());
                    }
                });
        Assertions.assertEquals("okay", mockService.transform("OKAY", operations));
        verify(mockLowercase, times(1)).transform("OKAY");
        verify(mockService, times(1)).transform("OKAY", operations);
    }
    @Test
    public void testReverse() {
        ReverseTransformer mockReverse = mock(ReverseTransformer.class);
        TextTransformerService mockService = mock(TextTransformerService.class);
        List<String> operations = new ArrayList<>();
        operations.add("upper");
        when(mockReverse.transform("MirEk")).thenReturn("KerIm");
        when(mockService.transform(anyString(), eq(operations))).thenAnswer(
                new Answer() {
                    public Object answer(InvocationOnMock invocationOnMock) {
                        Object[] args = invocationOnMock.getArguments();
                        Object mock = invocationOnMock.getMock();
                        return mockReverse.transform(args[0].toString());
                    }
                });
        Assertions.assertEquals("KerIm", mockService.transform("MirEk", operations));
        verify(mockService, times(1)).transform("MirEk", operations);
        verify(mockReverse, times(1)).transform("MirEk");
    }
}