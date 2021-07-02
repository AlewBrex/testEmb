package main.api.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BadResultResponse implements ResultResponse {
  private final Boolean result = false;
}
