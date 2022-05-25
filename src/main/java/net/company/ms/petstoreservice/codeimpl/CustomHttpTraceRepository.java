package net.company.ms.petstoreservice.codeimpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;

@Slf4j
/**
 * Just an inmemory sample tracing app for call tracing
 */
public class CustomHttpTraceRepository extends InMemoryHttpTraceRepository {

  public CustomHttpTraceRepository() {
    super();
    this.setCapacity(10000);
  }

  @Override
  public void add(HttpTrace trace) {
    String thePath = trace.getRequest().getUri().getRawPath();
    if (thePath.contains("petstore"))
      super.add(trace);
  }
}
