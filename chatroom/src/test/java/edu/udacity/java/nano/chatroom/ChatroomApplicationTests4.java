package edu.udacity.java.nano.chatroom;

import edu.udacity.java.nano.chatroom.chat.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ChatroomApplicationTests4 {
    @Autowired
    private MockMvc mockMvc;

    private Message message;

    @Test
    public void login() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

    @Test
    public void userJoin() throws Exception {
        this.mockMvc.perform(get("/index?username=john")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("john")));
    }
}