/*
 * Copyright 2022 Crown Copyright (Single Trade Window)
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

package uk.gov.cabinetoffice.bpdg.stw.tradetariffapi.web.converter;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import uk.gov.cabinetoffice.bpdg.stw.tradetariffapi.domain.TradeType;
import uk.gov.cabinetoffice.bpdg.stw.tradetariffapi.exception.EnumNotFoundException;

class TradeTypeStringToEnumConverterTest {
    TradeTypeStringToEnumConverter tradeTypeStringToEnumConverter= new TradeTypeStringToEnumConverter();

    @Test
    void shouldConvertToImportTradeType(){
        TradeType result = tradeTypeStringToEnumConverter.convert("IMPORT");
        assertThat(TradeType.IMPORT).isEqualTo(result);
    }

  @Test
  void shouldConvertToExportTradeType(){
    TradeType result = tradeTypeStringToEnumConverter.convert("EXPORT");
    assertThat(TradeType.EXPORT).isEqualTo(result);
  }

  @Test
  void shouldThrowEnumNotFoundException(){
    assertThatThrownBy(()->tradeTypeStringToEnumConverter.convert("TRADE"))
      .isInstanceOf(EnumNotFoundException.class);
  }
}

