/*

    epitope-service  T-cell epitope group matching service for HLA-DPB1 locus.
    Copyright (c) 2014-2015 National Marrow Donor Program (NMDP)
    
    This library is free software; you can redistribute it and/or modify it
    under the terms of the GNU Lesser General Public License as published
    by the Free Software Foundation; either version 3 of the License, or (at
    your option) any later version.
    
    This library is distributed in the hope that it will be useful, but WITHOUT
    ANY WARRANTY; with out even the implied warranty of MERCHANTABILITY or
    FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public
    License for more details.
    
    You should have received a copy of the GNU Lesser General Public License
    along with this library;  if not, write to the Free Software Foundation,
    Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307  USA.
    
    > http://www.gnu.org/licenses/lgpl.html

*/

package org.nmdp.service.epitope.resource;

import org.nmdp.service.epitope.domain.DetailRace;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("An allele and it's associated immunogenicity group")
public class AlleleView {

	private String allele;
    private Integer group;
    private DetailRace race;
    private Double frequency;
    private String error;

    @JsonCreator
    public AlleleView(
    		final @JsonProperty("allele") String allele, 
    		final @JsonProperty("group") Integer group,
    		final @JsonProperty("race") DetailRace race,
    		final @JsonProperty("frequency") Double frequency,
    		final @JsonProperty("error") String error)
    {
		this.allele = allele;
		this.group = group;
        this.race = race;
        this.frequency = frequency;
        this.error = error;
	}

	@ApiModelProperty(value="GL string for an allele", required=true)
	public String getAllele() {
		return allele;
	}

    @ApiModelProperty(value="Immunogenicity group associated with the allele", required=true)
    public Integer getGroup() {
        return group;
    }

    @ApiModelProperty(value="Race context of alleles for frequencies", required=false)
    public DetailRace getRace() {
        return race;
    }

    @ApiModelProperty(value="Frequency of the allele within the given population (ARS resolution)", required=false)
    public Double getFrequency() {
        return frequency;
    }

    @ApiModelProperty(value="Error involving resolution of the allele", required=false)
    public String getError() {
    	if (null == error && null == group) {
    		return "unknown group for allele: " + allele;
    	}
        return error;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allele == null) ? 0 : allele.hashCode());
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlleleView other = (AlleleView) obj;
		if (allele == null) {
			if (other.allele != null)
				return false;
		} else if (!allele.equals(other.allele))
			return false;
		if (group == null) {
			if (other.group != null)
				return false;
		} else if (!group.equals(other.group))
			return false;
		return true;
	}
	
}
