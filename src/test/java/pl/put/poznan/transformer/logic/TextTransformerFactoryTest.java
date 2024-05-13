package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TextTransformerFactoryTest
{
    @Test
    void testCreateTransformersWithEmptyList()
    {
        List<String> operations = new ArrayList<>();

        var transformers = TextTransformerFactory.createTransformers(operations);

        assertEquals(0, transformers.size());
    }

    @Test
    void testCreateTransformersWithUnknownOperationShouldThrowException()
    {
        var unknownOperation = "unknown";
        List<String> operations = new ArrayList<>();
        operations.add(unknownOperation);

        try
        {
            TextTransformerFactory.createTransformers(operations);
        }
        catch (IllegalArgumentException e)
        {
            assertEquals("Invalid transformation type: " + unknownOperation, e.getMessage());
        }
    }

    @Test
    void testCreateTransformers()
    {
        List<String> operations = new ArrayList<>();
        operations.add("upper");
        operations.add("capitalize");
        operations.add("lower");

        var transformers = TextTransformerFactory.createTransformers(operations);

        assertEquals(3, transformers.size());
        assertTrue(transformers.get(0) instanceof UppercaseTransformer);
        assertTrue(transformers.get(1) instanceof CapitalizeTransformer);
        assertTrue(transformers.get(2) instanceof LowercaseTransformer);
    }
}
