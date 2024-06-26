/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2007-2015 Broad Institute
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.broad.igv.sam;


import htsjdk.samtools.util.Locatable;
import org.broad.igv.feature.Strand;

public class ReadMate implements Locatable {

    private String chr;
    int start;
    private boolean negativeStrand;
    boolean mapped;

    public ReadMate(String chr, int start, boolean negativeStrand,
                    boolean isReadUnmappedFlag) {
        this.chr = chr;
        this.start = start;
        this.negativeStrand = negativeStrand;
        this.mapped = !isReadUnmappedFlag && !chr.equals("*");
    }

    public boolean isMapped() {
        return mapped;
    }

    public String positionString() {
        return chr + ":" + start + " (" + (isNegativeStrand() ? "-" : "+") + ")";
    }

    @Override
    public String getContig() {
        return chr;
    }

    public int getStart() {
        return start;
    }

    @Override
    public int getEnd() {
        throw new UnsupportedOperationException("ReadMate has an unknown end.");
    }

    public boolean isNegativeStrand() {
        return negativeStrand;
    }

    public Strand getStrand() {
        return negativeStrand ? Strand.NEGATIVE : Strand.POSITIVE;
    }

    public String getChr() {
        return getContig();
    }
}
