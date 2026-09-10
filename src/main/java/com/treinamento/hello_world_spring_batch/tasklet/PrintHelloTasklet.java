package com.treinamento.hello_world_spring_batch.tasklet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@StepScope
public class PrintHelloTasklet implements Tasklet {

    // Instância do Logger para a classe
    private static final Logger log = LoggerFactory.getLogger(PrintHelloTasklet.class);

    @Value("${name}")
    private String name;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        // Uso do Logger padronizado com o restante do Spring
        log.info("Olá {} !", name);
        return RepeatStatus.FINISHED;
    }
}