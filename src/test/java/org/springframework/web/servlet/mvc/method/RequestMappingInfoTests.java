/*
 * Copyright 2002-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.web.servlet.mvc.method;

import java.util.Collections;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.handler.PathPatternsParameterizedTest;
import org.springframework.web.util.pattern.PathPatternParser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.web.bind.annotation.RequestMethod.GET;


/**
 * Test fixture for {@link RequestMappingInfo} tests.
 *
 * @author Arjen Poutsma
 * @author Rossen Stoyanchev
 */
class RequestMappingInfoTests {

	@SuppressWarnings("unused")
	static Stream<RequestMappingInfo.Builder> pathPatternsArguments() {
		RequestMappingInfo.BuilderConfiguration config = new RequestMappingInfo.BuilderConfiguration();
		config.setPatternParser(new PathPatternParser());
		return Stream.of(RequestMappingInfo.paths().options(config), RequestMappingInfo.paths());
	}


	@PathPatternsParameterizedTest
	void createEmpty(RequestMappingInfo.Builder infoBuilder) {

		// gh-22543
		RequestMappingInfo info = infoBuilder.build();
		assertThat(info.getPatternValues()).isEqualTo(Collections.singleton(""));
		assertThat(info.getMethodsCondition().getMethods().size()).isEqualTo(0);
		assertThat(info.getParamsCondition()).isNotNull();
		assertThat(info.getHeadersCondition()).isNotNull();
		assertThat(info.getConsumesCondition().isEmpty()).isTrue();
		assertThat(info.getProducesCondition().isEmpty()).isTrue();
		assertThat(info.getCustomCondition()).isNull();

		RequestMappingInfo anotherInfo = infoBuilder.build();
		assertThat(info.getActivePatternsCondition()).isSameAs(anotherInfo.getActivePatternsCondition());
		assertThat(info.getPatternsCondition()).isSameAs(anotherInfo.getPatternsCondition());
		assertThat(info.getMethodsCondition()).isSameAs(anotherInfo.getMethodsCondition());
		assertThat(info.getParamsCondition()).isSameAs(anotherInfo.getParamsCondition());
		assertThat(info.getHeadersCondition()).isSameAs(anotherInfo.getHeadersCondition());
		assertThat(info.getConsumesCondition()).isSameAs(anotherInfo.getConsumesCondition());
		assertThat(info.getProducesCondition()).isSameAs(anotherInfo.getProducesCondition());
		assertThat(info.getCustomCondition()).isSameAs(anotherInfo.getCustomCondition());

		RequestMappingInfo result = info.combine(anotherInfo);
		assertThat(info.getActivePatternsCondition()).isSameAs(result.getActivePatternsCondition());
		assertThat(info.getMethodsCondition()).isSameAs(result.getMethodsCondition());
		assertThat(info.getParamsCondition()).isSameAs(result.getParamsCondition());
		assertThat(info.getHeadersCondition()).isSameAs(result.getHeadersCondition());
		assertThat(info.getConsumesCondition()).isSameAs(result.getConsumesCondition());
		assertThat(info.getProducesCondition()).isSameAs(result.getProducesCondition());
		assertThat(info.getCustomCondition()).isSameAs(result.getCustomCondition());
	}


	@PathPatternsParameterizedTest
	void equalsMethod(RequestMappingInfo.Builder infoBuilder) {
		RequestMappingInfo info1 = infoBuilder.paths("/foo").methods(GET)
				.params("foo=bar", "customFoo=customBar").headers("foo=bar")
				.consumes("text/plain").produces("text/plain")
				.build();

		RequestMappingInfo info2 = infoBuilder.paths("/foo").methods(GET)
				.params("foo=bar", "customFoo=customBar").headers("foo=bar")
				.consumes("text/plain").produces("text/plain")
				.build();

		assertThat(info2).isEqualTo(info1);
		assertThat(info2.hashCode()).isEqualTo(info1.hashCode());

		info2 = infoBuilder.paths("/foo", "/NOOOOOO").methods(GET)
				.params("foo=bar", "customFoo=customBar").headers("foo=bar")
				.consumes("text/plain").produces("text/plain")
				.build();

		assertThat(info1.equals(info2)).isFalse();
		assertThat(info2.hashCode()).isNotEqualTo(info1.hashCode());

		info2 = infoBuilder.paths("/foo").methods(GET, RequestMethod.POST)
				.params("foo=bar", "customFoo=customBar").headers("foo=bar")
				.consumes("text/plain").produces("text/plain")
				.build();

		assertThat(info1.equals(info2)).isFalse();
		assertThat(info2.hashCode()).isNotEqualTo(info1.hashCode());

		info2 = infoBuilder.paths("/foo").methods(GET)
				.params("/NOOOOOO", "customFoo=customBar").headers("foo=bar")
				.consumes("text/plain").produces("text/plain")
				.build();

		assertThat(info1.equals(info2)).isFalse();
		assertThat(info2.hashCode()).isNotEqualTo(info1.hashCode());

		info2 = infoBuilder.paths("/foo").methods(GET)
				.params("foo=bar", "customFoo=customBar").headers("/NOOOOOO")
				.consumes("text/plain").produces("text/plain")
				.build();

		assertThat(info1.equals(info2)).isFalse();
		assertThat(info2.hashCode()).isNotEqualTo(info1.hashCode());

		info2 = infoBuilder.paths("/foo").methods(GET)
				.params("foo=bar", "customFoo=customBar").headers("foo=bar")
				.consumes("text/NOOOOOO").produces("text/plain")
				.build();

		assertThat(info1.equals(info2)).isFalse();
		assertThat(info2.hashCode()).isNotEqualTo(info1.hashCode());

		info2 = infoBuilder.paths("/foo").methods(GET)
				.params("foo=bar", "customFoo=customBar").headers("foo=bar")
				.consumes("text/plain").produces("text/NOOOOOO")
				.build();

		assertThat(info1.equals(info2)).isFalse();
		assertThat(info2.hashCode()).isNotEqualTo(info1.hashCode());

		info2 = infoBuilder.paths("/foo").methods(GET)
				.params("foo=bar", "customFoo=NOOOOOO").headers("foo=bar")
				.consumes("text/plain").produces("text/plain")
				.build();

		assertThat(info1.equals(info2)).isFalse();
		assertThat(info2.hashCode()).isNotEqualTo(info1.hashCode());
	}



	@Test
	void mutate() {
		RequestMappingInfo.BuilderConfiguration options = new RequestMappingInfo.BuilderConfiguration();
		options.setPatternParser(new PathPatternParser());

		RequestMappingInfo info1 = RequestMappingInfo.paths("/foo")
				.methods(GET).headers("h1=hv1").params("q1=qv1")
				.consumes("application/json").produces("application/json")
				.mappingName("testMapping").options(options)
				.build();

		RequestMappingInfo info2 = info1.mutate().produces("application/hal+json").build();

		assertThat(info2.getName()).isEqualTo(info1.getName());
		assertThat(info2.getPatternsCondition()).isNull();
		assertThat(info2.getPathPatternsCondition()).isEqualTo(info1.getPathPatternsCondition());
		assertThat(info2.getHeadersCondition()).isEqualTo(info1.getHeadersCondition());
		assertThat(info2.getParamsCondition()).isEqualTo(info1.getParamsCondition());
		assertThat(info2.getConsumesCondition()).isEqualTo(info1.getConsumesCondition());
		assertThat(info2.getProducesCondition().getProducibleMediaTypes())
				.containsOnly(MediaType.parseMediaType("application/hal+json"));
	}

}
