package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.TextTransformerService;
import pl.put.poznan.transformer.rest.model.ResponseModel;
import pl.put.poznan.transformer.rest.model.TransformModel;

import java.util.Arrays;


@RestController
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    private final TextTransformerService textTransformerService = new TextTransformerService();

    @PostMapping(path = "/transform", produces = "application/json")
    public ResponseModel get(@RequestBody TransformModel model) {

        logger.debug(model.getText());
        logger.debug(Arrays.toString(model.getTransforms()));

        return new ResponseModel(
                textTransformerService.transform(model.getText(), Arrays.asList(model.getTransforms()))
        );
    }
}


