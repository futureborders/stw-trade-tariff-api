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

package uk.gov.cabinetoffice.bpdg.stw.tradetariffapi.service.measureoptions;

import static uk.gov.cabinetoffice.bpdg.stw.tradetariffapi.domain.TradeType.IMPORT;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import uk.gov.cabinetoffice.bpdg.stw.tradetariffapi.dao.model.DocumentCodeDescription;
import uk.gov.cabinetoffice.bpdg.stw.tradetariffapi.domain.DocumentCodeMeasureOption;
import uk.gov.cabinetoffice.bpdg.stw.tradetariffapi.domain.DocumentaryMeasureCondition;
import uk.gov.cabinetoffice.bpdg.stw.tradetariffapi.domain.Locale;
import uk.gov.cabinetoffice.bpdg.stw.tradetariffapi.domain.MeasureCondition;
import uk.gov.cabinetoffice.bpdg.stw.tradetariffapi.domain.MeasureConditionCode;
import uk.gov.cabinetoffice.bpdg.stw.tradetariffapi.domain.MeasureOptions;

@ExtendWith(MockitoExtension.class)
class MultipleMeasureOptionsHandlerTest {

  @Mock private SingleMeasureOptionHandler singleMeasureOptionHandler;

  @InjectMocks private MultipleMeasureOptionsHandler multipleMeasureOptionsHandler;

  @ParameterizedTest
  @EnumSource
  @DisplayName("no measures")
  void shouldReturnEmptyWhenNoMeasuresArePassed(Locale locale) {
    StepVerifier.create(multipleMeasureOptionsHandler.getMeasureOptions(null, IMPORT, locale))
        .verifyComplete();

    StepVerifier.create(multipleMeasureOptionsHandler.getMeasureOptions(List.of(), IMPORT, locale))
        .verifyComplete();
  }

  @DisplayName("processing multiple measure")
  @ParameterizedTest
  @EnumSource(Locale.class)
  void shouldProcessMultipleMeasures(Locale locale) {
    String documentCode1 = "C123";
    String documentCode2 = "C223";
    String documentCode3 = "C323";

    MeasureConditionCode bMeasureConditionCode = MeasureConditionCode.B;
    MeasureCondition certificateMeasureConditionWithMeasureConditionB =
        DocumentaryMeasureCondition.builder()
            .id("1000")
            .conditionCode(bMeasureConditionCode)
            .documentCode(documentCode1)
            .requirement("certificate requirement")
            .build();
    MeasureConditionCode cMeasureConditionCode = MeasureConditionCode.C;
    MeasureCondition certificateMeasureConditionWithMeasureConditionC =
        DocumentaryMeasureCondition.builder()
            .id("1001")
            .conditionCode(cMeasureConditionCode)
            .documentCode(documentCode2)
            .requirement("certificate requirement")
            .build();
    MeasureConditionCode dMeasureConditionCode = MeasureConditionCode.D;
    MeasureCondition certificateMeasureConditionWithMeasureConditionD =
        DocumentaryMeasureCondition.builder()
            .id("1002")
            .conditionCode(dMeasureConditionCode)
            .documentCode(documentCode3)
            .requirement("certificate requirement")
            .build();

    MeasureOptions measureOptionForB =
        MeasureOptions.builder()
            .options(
                List.of(
                    DocumentCodeMeasureOption.builder()
                        .totalNumberOfCertificates(1)
                        .documentCodeDescription(
                            DocumentCodeDescription.builder().documentCode(documentCode1).build())
                        .build()))
            .build();
    MeasureOptions measureOptionForC =
        MeasureOptions.builder()
            .options(
                List.of(
                    DocumentCodeMeasureOption.builder()
                        .totalNumberOfCertificates(1)
                        .documentCodeDescription(
                            DocumentCodeDescription.builder().documentCode(documentCode2).build())
                        .build()))
            .build();
    MeasureOptions measureOptionForD =
        MeasureOptions.builder()
            .options(
                List.of(
                    DocumentCodeMeasureOption.builder()
                        .totalNumberOfCertificates(1)
                        .documentCodeDescription(
                            DocumentCodeDescription.builder().documentCode(documentCode3).build())
                        .build()))
            .build();
    Mockito.when(
            singleMeasureOptionHandler.getMeasureOption(
                List.of(certificateMeasureConditionWithMeasureConditionB), IMPORT, locale))
        .thenReturn(Mono.just(measureOptionForB));
    Mockito.when(
            singleMeasureOptionHandler.getMeasureOption(
                List.of(certificateMeasureConditionWithMeasureConditionC), IMPORT, locale))
        .thenReturn(Mono.just(measureOptionForC));
    Mockito.when(
            singleMeasureOptionHandler.getMeasureOption(
                List.of(certificateMeasureConditionWithMeasureConditionD), IMPORT, locale))
        .thenReturn(Mono.just(measureOptionForD));

    StepVerifier.create(
            multipleMeasureOptionsHandler.getMeasureOptions(
                List.of(
                    certificateMeasureConditionWithMeasureConditionB,
                    certificateMeasureConditionWithMeasureConditionC,
                    certificateMeasureConditionWithMeasureConditionD),
                IMPORT,
                locale))
        .expectNext(measureOptionForB, measureOptionForC, measureOptionForD)
        .verifyComplete();
  }
}
