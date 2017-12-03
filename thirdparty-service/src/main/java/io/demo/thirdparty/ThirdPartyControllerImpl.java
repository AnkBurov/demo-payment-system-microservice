package io.demo.thirdparty;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThirdPartyControllerImpl implements ThirdPartyController {

    @Override
    public String getString() {
        return "Third party value";
    }
}
