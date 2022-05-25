package net.company.ms.petstoreservice.codeimpl;

import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AppStartedConfig {
  @Bean
  HttpTraceRepository httpTraceRepository() {
    return new CustomHttpTraceRepository();
  }
}
