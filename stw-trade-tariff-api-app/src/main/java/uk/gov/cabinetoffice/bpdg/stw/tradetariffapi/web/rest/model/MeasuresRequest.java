/*
 * Copyright 2021 Crown Copyright (Single Trade Window)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.cabinetoffice.bpdg.stw.tradetariffapi.web.rest.model;

import java.time.LocalDate;
import java.util.Optional;
import lombok.Builder;
import lombok.Value;
import uk.gov.cabinetoffice.bpdg.stw.tradetariffapi.domain.Locale;
import uk.gov.cabinetoffice.bpdg.stw.tradetariffapi.domain.TradeType;

@Value
@Builder
public class MeasuresRequest {

  String commodityCode;
  String originCountry;
  String destinationCountry;
  TradeType tradeType;
  String additionalCode;
  LocalDate dateOfTrade;
  Locale locale;

  public Optional<String> getAdditionalCode() {
    return Optional.ofNullable(additionalCode);
  }
}
