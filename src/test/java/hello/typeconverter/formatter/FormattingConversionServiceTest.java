package hello.typeconverter.formatter;

import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import hello.typeconverter.type.IpPort;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;

import static org.assertj.core.api.Assertions.*;

class FormattingConversionServiceTest {
    @Test
    void formattingConversionService() {
        FormattingConversionService formattingConversionService
                = new DefaultFormattingConversionService();

        //컨버터 등록
        formattingConversionService.addConverter(new IpPortToStringConverter());
        formattingConversionService.addConverter(new StringToIpPortConverter());

        //포매터 등록
        formattingConversionService.addFormatter(new MyNumberFormatter());

        //컨버터 사용
        IpPort ipPort = formattingConversionService.convert("127.0.0.1:8080", IpPort.class);
        assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1", 8080));

        //포매터 사용
        assertThat(formattingConversionService.convert(1000, String.class))
                .isEqualTo("1,000");
        assertThat(formattingConversionService.convert("1,000", Long.class))
                .isEqualTo(1000L);
    }
}
