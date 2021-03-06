/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.cxf.systest.jaxrs.tracing.htrace;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.apache.htrace.HTraceConfiguration;
import org.apache.htrace.Span;
import org.apache.htrace.SpanReceiver;

/**
 * Test HTrace Span receiver
 */
public class TestSpanReceiver implements SpanReceiver {
    private static Collection<Span> spans = new HashSet<Span>();

    public TestSpanReceiver(final HTraceConfiguration conf) {
    }

    public Collection<Span> getSpans() {
        return spans;
    }

    @Override
    public void close() throws IOException {
    }

    @Override
    public void receiveSpan(Span span) {
        spans.add(span);
    }
    
    public static void clear() {
        spans.clear();
    }
    
    public static List<Span> getAllSpans() {
        return new ArrayList< Span >(spans);
    }

}