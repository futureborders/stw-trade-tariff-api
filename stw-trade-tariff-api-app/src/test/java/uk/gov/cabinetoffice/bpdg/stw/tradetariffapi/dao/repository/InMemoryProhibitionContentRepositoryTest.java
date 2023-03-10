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

package uk.gov.cabinetoffice.bpdg.stw.tradetariffapi.dao.repository;

import static uk.gov.cabinetoffice.bpdg.stw.tradetariffapi.domain.Locale.EN;

import java.util.List;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;
import uk.gov.cabinetoffice.bpdg.stw.tradetariffapi.dao.model.ProhibitionDescription;
import uk.gov.cabinetoffice.bpdg.stw.tradetariffapi.domain.TradeType;

class InMemoryProhibitionContentRepositoryTest {

  private final InMemoryProhibitionContentRepository inMemoryProhibitionContentRepository =
    new InMemoryProhibitionContentRepository();

  @Test
  void shouldReturnImportAndExportProhibitions() {
    StepVerifier.create(inMemoryProhibitionContentRepository.findAll())
      .expectNext(
        ProhibitionDescription.builder()
          .applicableTradeTypes(List.of(TradeType.IMPORT))
          .legalAct("C2100260")
          .originCountry("BD")
          .description(
            "## You are not allowed to import betel leaves ('Piper Betle') from Bangladesh%0A%0AFoodstuffs containing or consisting of betel leaves from Bangladesh are banned in the UK.%0A%0ABetel leaves (also known as 'paan leaf') from Bangladesh can carry Salmonella strains.%0A%0A[Read more on Regulation 2019/1793](https://www.legislation.gov.uk/eur/2019/1793/contents)")
          .locale(EN)
          .build())
      .expectNext(
        ProhibitionDescription.builder()
          .applicableTradeTypes(List.of(TradeType.IMPORT))
          .legalAct("C2100260")
          .originCountry("NG")
          .description(
            "## You are not allowed to import dried beans from Nigeria%0A%0AFoodstuffs consisting of dried beans from Nigeria are banned in the UK.%0A%0ADried beans from Nigeria carry high levels of pesticide.%0A%0A[Read more on Regulation 2019/1793](https://www.legislation.gov.uk/eur/2019/1793/contents)")
          .locale(EN)
          .build())
      .expectNext(
        ProhibitionDescription.builder()
          .applicableTradeTypes(List.of(TradeType.IMPORT))
          .legalAct("X1904110")
          .description(
            "## Import prohibition%0A%0A[Read the North Korea sanctions guidance](https://www.gov.uk/government/publications/democratic-peoples-republic-of-korea-sanctions-guidance)")
          .locale(EN)
          .build())
      .expectNext(
        ProhibitionDescription.builder()
          .applicableTradeTypes(List.of(TradeType.IMPORT))
          .legalAct("X2006420")
          .description(
            "## You are not allowed to import charcoal from Somalia%0A%0AThere are [sanctions banning the import of charcoal consigned from or originating in Somalia](https://www.gov.uk/government/publications/somalia-sanctions-guidance)")
          .locale(EN)
          .build())
      .expectNext(
        ProhibitionDescription.builder()
          .applicableTradeTypes(List.of(TradeType.IMPORT))
          .legalAct("A1907950")
          .description(
            "## You are not allowed to import live and chilled bivalve molluscs for human consumption from Turkey%0A%0AThis includes:%0A%0A- clams%0A- mussels%0A- scallops%0A- oysters%0A%0AThere is a ban on importing these goods.%0A%0A[Read the Regulation (EU 743/2103)](https://www.legislation.gov.uk/eur/2013/743)")
          .locale(EN)
          .build())
      .expectNext(
        ProhibitionDescription.builder()
          .applicableTradeTypes(List.of(TradeType.IMPORT))
          .legalAct("X2013540")
          .description(
            "## You are not allowed to re-import tiered price medical products%0A%0AThe re-importation of certain tiered-priced products ([key medicines](https://www.legislation.gov.uk/uksi/2020/1354/contents/made)) is banned across the UK.%0A%0ATiered-priced products are destined for developing countries and sold to these countries at heavily reduced prices to avoid trade diversion.%0A%0A[Read how the government monitors imports into the UK](https://www.gov.uk/guidance/import-controls)")
          .locale(EN)
          .build())
      .expectNext(
        ProhibitionDescription.builder()
          .applicableTradeTypes(List.of(TradeType.IMPORT))
          .legalAct("X2007070")
          .description(
            "## There are restrictions on the import of these goods from Iraq%0A%0AThere are [restrictions on the import of cultural goods from Iraq](https://www.gov.uk/government/collections/uk-sanctions-on-iraq)%0A%0AYou must ensure that your goods were not illegally removed from Iraq since 6 August 1990.%0A%0ARead [further information on the import of cultural goods](https://www.gov.uk/guidance/exporting-or-importing-objects-of-cultural-interest)")
          .locale(EN)
          .build())
      .expectNext(
        ProhibitionDescription.builder()
          .applicableTradeTypes(List.of(TradeType.IMPORT))
          .legalAct("X1905830")
          .description(
            "## You must have a licence to import ozone-depleting substances (ODS)%0A%0AIt is illegal to import ODS without a valid licence. Some ODS are banned in the UK.%0A%0A[Read the requirements for working with ODS](https://www.gov.uk/government/collections/ozone-depleting-substances-guidance-for-users-producers-and-traders)")
          .locale(EN)
          .build())
      .expectNext(
        ProhibitionDescription.builder()
          .applicableTradeTypes(List.of(TradeType.IMPORT))
          .legalAct("X1907920")
          .description(
            "## You are not allowed to import these goods from Syria%0A%0AThere are sanctions banning the import of certain goods from Syria.%0A%0A[Read the Syria sanctions guidance](https://www.gov.uk/government/collections/uk-sanctions-on-syria)")
          .locale(EN)
          .build())
      .expectNext(
        ProhibitionDescription.builder()
          .applicableTradeTypes(List.of(TradeType.IMPORT))
          .legalAct("R2006251")
          .originCountry("NG")
          .description(
            "## You are not allowed to import dried beans from Nigeria%0A%0AFoodstuffs consisting of dried beans from Nigeria are banned in the UK.%0A%0ADried beans from Nigeria carry high levels of pesticide.%0A%0A[Read more on Regulation 2019/1793](https://www.legislation.gov.uk/eur/2019/1793/contents)")
          .locale(EN)
          .build())
      .expectNext(
        ProhibitionDescription.builder()
          .applicableTradeTypes(List.of(TradeType.IMPORT))
          .legalAct("R1509360")
          .description(
            "## Import prohibition%0A%0A[Read the North Korea sanctions guidance](https://www.gov.uk/government/publications/democratic-peoples-republic-of-korea-sanctions-guidance)")
          .locale(EN)
          .build())
      .expectNext(
        ProhibitionDescription.builder()
          .applicableTradeTypes(List.of(TradeType.IMPORT))
          .legalAct("R1715092")
          .description(
            "## Import prohibition%0A%0A[Read the North Korea sanctions guidance](https://www.gov.uk/government/publications/democratic-peoples-republic-of-korea-sanctions-guidance)")
          .locale(EN)
          .build())
      .expectNext(
        ProhibitionDescription.builder()
          .applicableTradeTypes(List.of(TradeType.IMPORT))
          .legalAct("R1715094")
          .description(
            "## Import prohibition%0A%0A[Read the North Korea sanctions guidance](https://www.gov.uk/government/publications/democratic-peoples-republic-of-korea-sanctions-guidance)")
          .locale(EN)
          .build())
      .expectNext(
        ProhibitionDescription.builder()
          .applicableTradeTypes(List.of(TradeType.IMPORT))
          .legalAct("R1715095")
          .description(
            "## Import prohibition%0A%0A[Read the North Korea sanctions guidance](https://www.gov.uk/government/publications/democratic-peoples-republic-of-korea-sanctions-guidance)")
          .locale(EN)
          .build())
      .expectNext(
        ProhibitionDescription.builder()
          .applicableTradeTypes(List.of(TradeType.IMPORT))
          .legalAct("R1715097")
          .description(
            "## Import prohibition%0A%0A[Read the North Korea sanctions guidance](https://www.gov.uk/government/publications/democratic-peoples-republic-of-korea-sanctions-guidance)")
          .locale(EN)
          .build())
      .expectNext(
        ProhibitionDescription.builder()
          .applicableTradeTypes(List.of(TradeType.IMPORT))
          .legalAct("R1715099")
          .description(
            "## Import prohibition%0A%0A[Read the North Korea sanctions guidance](https://www.gov.uk/government/publications/democratic-peoples-republic-of-korea-sanctions-guidance)")
          .locale(EN)
          .build())
      .expectNext(
        ProhibitionDescription.builder()
          .applicableTradeTypes(List.of(TradeType.IMPORT))
          .legalAct("R171509A")
          .description(
            "## Import prohibition%0A%0A[Read the North Korea sanctions guidance](https://www.gov.uk/government/publications/democratic-peoples-republic-of-korea-sanctions-guidance)")
          .locale(EN)
          .build())
      .expectNext(
        ProhibitionDescription.builder()
          .applicableTradeTypes(List.of(TradeType.IMPORT))
          .legalAct("R171509C")
          .description(
            "## Import prohibition%0A%0A[Read the North Korea sanctions guidance](https://www.gov.uk/government/publications/democratic-peoples-republic-of-korea-sanctions-guidance)")
          .locale(EN)
          .build())
      .expectNext(
        ProhibitionDescription.builder()
          .applicableTradeTypes(List.of(TradeType.IMPORT))
          .legalAct("R1715480")
          .description(
            "## Import prohibition%0A%0A[Read the North Korea sanctions guidance](https://www.gov.uk/government/publications/democratic-peoples-republic-of-korea-sanctions-guidance)")
          .locale(EN)
          .build())
      .expectNext(
        ProhibitionDescription.builder()
          .applicableTradeTypes(List.of(TradeType.IMPORT))
          .legalAct("R1718360")
          .description(
            "## Import prohibition%0A%0A[Read the North Korea sanctions guidance](https://www.gov.uk/government/publications/democratic-peoples-republic-of-korea-sanctions-guidance)")
          .locale(EN)
          .build())
      .expectNext(
        ProhibitionDescription.builder()
          .applicableTradeTypes(List.of(TradeType.IMPORT))
          .legalAct("R1802850")
          .description(
            "## Import prohibition%0A%0A[Read the North Korea sanctions guidance](https://www.gov.uk/government/publications/democratic-peoples-republic-of-korea-sanctions-guidance)")
          .locale(EN)
          .build())
      .expectNext(
        ProhibitionDescription.builder()
          .applicableTradeTypes(List.of(TradeType.IMPORT))
          .legalAct("R1206420")
          .description(
            "## You are not allowed to import charcoal from Somalia%0A%0AThere are [sanctions banning the import of charcoal consigned from or originating in Somalia](https://www.gov.uk/government/publications/somalia-sanctions-guidance)")
          .locale(EN)
          .build())
      .expectNext(
        ProhibitionDescription.builder()
          .applicableTradeTypes(List.of(TradeType.IMPORT))
          .legalAct("R1307430")
          .description(
            "## You are not allowed to import live and chilled bivalve molluscs for human consumption from Turkey%0A%0AThis includes:%0A%0A- clams%0A- mussels%0A- scallops%0A- oysters%0A%0AThere is a ban on importing these goods.%0A%0A[Read the Regulation (EU 743/2103)](https://www.legislation.gov.uk/eur/2013/743)")
          .locale(EN)
          .build())
      .expectNext(
        ProhibitionDescription.builder()
          .applicableTradeTypes(List.of(TradeType.IMPORT))
          .legalAct("R0910050")
          .description(
            "## You must have a licence to import ozone-depleting substances (ODS)%0A%0AIt is illegal to import ODS without a valid licence. Some ODS are banned in the UK.%0A%0A[Read the requirements for working with ODS](https://www.gov.uk/government/collections/ozone-depleting-substances-guidance-for-users-producers-and-traders)")
          .locale(EN)
          .build())
      .expectNext(
        ProhibitionDescription.builder()
          .applicableTradeTypes(List.of(TradeType.IMPORT))
          .legalAct("R1200360")
          .description(
            "## You are not allowed to import these goods from Syria%0A%0AThere are sanctions banning the import of certain goods from Syria.%0A%0A[Read the Syria sanctions guidance](https://www.gov.uk/government/collections/uk-sanctions-on-syria)")
          .locale(EN)
          .build())
      .expectNext(
        ProhibitionDescription.builder()
          .applicableTradeTypes(List.of(TradeType.IMPORT))
          .legalAct("R1201680")
          .description(
            "## You are not allowed to import these goods from Syria%0A%0AThere are sanctions banning the import of certain goods from Syria.%0A%0A[Read the Syria sanctions guidance](https://www.gov.uk/government/collections/uk-sanctions-on-syria)")
          .locale(EN)
          .build())
      .expectNext(
        ProhibitionDescription.builder()
          .applicableTradeTypes(List.of(TradeType.IMPORT))
          .legalAct("R1205090")
          .description(
            "## You are not allowed to import these goods from Syria%0A%0AThere are sanctions banning the import of certain goods from Syria.%0A%0A[Read the Syria sanctions guidance](https://www.gov.uk/government/collections/uk-sanctions-on-syria)")
          .locale(EN)
          .build())
      .expectNext(
        ProhibitionDescription.builder()
          .applicableTradeTypes(List.of(TradeType.IMPORT))
          .legalAct("R1205091")
          .description(
            "## You are not allowed to import these goods from Syria%0A%0AThere are sanctions banning the import of certain goods from Syria.%0A%0A[Read the Syria sanctions guidance](https://www.gov.uk/government/collections/uk-sanctions-on-syria)")
          .locale(EN)
          .build())
      .expectNext(
        ProhibitionDescription.builder()
          .applicableTradeTypes(List.of(TradeType.IMPORT))
          .legalAct("R1306970")
          .description(
            "## You are not allowed to import these goods from Syria%0A%0AThere are sanctions banning the import of certain goods from Syria.%0A%0A[Read the Syria sanctions guidance](https://www.gov.uk/government/collections/uk-sanctions-on-syria)")
          .locale(EN)
          .build())
      .expectNext(
        ProhibitionDescription.builder()
          .applicableTradeTypes(List.of(TradeType.IMPORT))
          .legalAct("R1313320")
          .description(
            "## You are not allowed to import these goods from Syria%0A%0AThere are sanctions banning the import of certain goods from Syria.%0A%0A[Read the Syria sanctions guidance](https://www.gov.uk/government/collections/uk-sanctions-on-syria)")
          .locale(EN)
          .build())
      .expectNext(
        ProhibitionDescription.builder()
          .applicableTradeTypes(List.of(TradeType.IMPORT))
          .legalAct("R1413230")
          .description(
            "## You are not allowed to import these goods from Syria%0A%0AThere are sanctions banning the import of certain goods from Syria.%0A%0A[Read the Syria sanctions guidance](https://www.gov.uk/government/collections/uk-sanctions-on-syria)")
          .locale(EN)
          .build())
      .expectNext(
        ProhibitionDescription.builder()
          .applicableTradeTypes(List.of(TradeType.IMPORT))
          .legalAct("R2006250")
          .description(
            "## You are not allowed to import these goods from Syria%0A%0AThere are sanctions banning the import of certain goods from Syria.%0A%0A[Read the Syria sanctions guidance](https://www.gov.uk/government/collections/uk-sanctions-on-syria)")
          .locale(EN)
          .build())
      .expectNext(
        ProhibitionDescription.builder()
          .applicableTradeTypes(List.of(TradeType.EXPORT))
          .legalAct("X1904110")
          .description(
            "## There are restrictions on the export of these goods to North Korea%0A%0AFor more information, see [North Korea sanctions guidance](https://www.gov.uk/government/publications/democratic-peoples-republic-of-korea-sanctions-guidance)")
          .locale(EN)
          .build())
      .expectNext(
        ProhibitionDescription.builder()
          .applicableTradeTypes(List.of(TradeType.EXPORT))
          .legalAct("X1906000")
          .description(
            "## There are restrictions on the export of these goods to Belarus%0A%0AFor more information, see [Belarus sanctions guidance](https://www.gov.uk/government/publications/republic-of-belarus-sanctions-guidance)")
          .locale(EN)
          .build())
      .verifyComplete();
  }
}
