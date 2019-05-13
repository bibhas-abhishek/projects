package com.leviathan.springbatch.batch;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SampleTasklet implements Tasklet, StepExecutionListener {

    @Override
    public void beforeStep(StepExecution stepExecution) {
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        Map<String, JobParameter> parameterMap = stepExecution.getJobExecution().getJobParameters().getParameters();
        Long startTime = (Long) parameterMap.get("time").getValue();
        System.out.println("job executed in: " + (System.currentTimeMillis() - startTime));
        if (Optional.ofNullable(parameterMap.get("list")).isPresent()) {
            String list = (String) parameterMap.get("list").getValue();
            System.out.println("list: " + Stream.of(list.split(",")).map(Integer::parseInt).collect(Collectors.toList()));
        }
        return ExitStatus.COMPLETED;
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {
        System.out.println("JOB COMPLETED");
        return RepeatStatus.FINISHED;
    }

}
