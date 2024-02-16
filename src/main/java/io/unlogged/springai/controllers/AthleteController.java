package io.unlogged.springai.controllers;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AthleteController {

    private String promptTemplate;
    private final ChatClient chatClient;

    public AthleteController(ChatClient chatClient, @Value("${app.promptTemplate}") String promptTemplate) {
        this.chatClient = chatClient;
        this.promptTemplate = promptTemplate;
    }

    @GetMapping("/topAthlete")
    public String topAthlete(@RequestParam("subject") String subject) {
        PromptTemplate pt = new PromptTemplate(promptTemplate);
        String renderedPrompt = pt.render(Map.of("subject", subject));
        return chatClient.call(renderedPrompt);
    }
}
