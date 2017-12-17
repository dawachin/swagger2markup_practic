package com.example.swagger2maekup_practic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureRestDocs(outputDir = "build/asciidoc/snippets")
@SpringBootTest(classes = {Swagger2maekupPracticApplication.class, SwaggerConfig.class})
@AutoConfigureMockMvc
public class Swagger2maekupPracticApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void addANewMember() throws Exception {
		this.mockMvc.perform(post("/member/add").content(createMember())
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(document("addMemberPOST", preprocessResponse(prettyPrint())))
				.andExpect(status().isOk());
	}

    @Test
    public void createSpringfoxSwaggerJson() throws Exception {

        //String designFirstSwaggerLocation = Swagger2MarkupTest.class.getResource("/swagger.yaml").getPath();
        //String outputDir = System.getProperty("io.springfox.staticdocs.outputDir");
        String outputDir = "build/swagger";
        MvcResult mvcResult = this.mockMvc.perform(get("/v2/api-docs")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        MockHttpServletResponse response = mvcResult.getResponse();
        String swaggerJson = response.getContentAsString();
        Files.createDirectories(Paths.get(outputDir));
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputDir, "swagger.json"), StandardCharsets.UTF_8)){
            writer.write(swaggerJson);
        }
    }

	private String createMember() throws JsonProcessingException {
        Member member = new Member("名前", "27", "GSS0001");
        return new ObjectMapper().writeValueAsString(member);
    }

}
