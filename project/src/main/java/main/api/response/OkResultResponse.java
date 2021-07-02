package main.api.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class OkResultResponse implements ResultResponse {
  private final Boolean result = true;
}
