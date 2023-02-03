// Copyright 2021 Crown Copyright (Single Trade Window)
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package uk.gov.cabinetoffice.bpdg.stw.tradetariffapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import uk.gov.cabinetoffice.bpdg.stw.tradetariffapi.web.converter.LocaleStringToEnumConverter;
import uk.gov.cabinetoffice.bpdg.stw.tradetariffapi.web.converter.TradeTypeStringToEnumConverter;
import uk.gov.cabinetoffice.bpdg.stw.tradetariffapi.web.converter.UkCountryStringToEnumConverter;

@Configuration
@EnableWebFlux
public class WebFluxConfig implements WebFluxConfigurer {

  @Override
  public void addFormatters(FormatterRegistry registry) {
    registry.addConverter(new LocaleStringToEnumConverter());
    registry.addConverter(new TradeTypeStringToEnumConverter());
    registry.addConverter(new UkCountryStringToEnumConverter());
  }
}
