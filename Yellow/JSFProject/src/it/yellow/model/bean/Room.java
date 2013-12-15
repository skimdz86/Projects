package it.yellow.model.bean;

import java.math.BigDecimal;
import java.util.List;

public class Room {

	
	private String maxOccupants;
	private String roomDescription;
	private BigDecimal totalCharge;
	private List<String> valueAdds;
	private String remainingRooms;
	private String url;
	public String getMaxOccupants() {
		return maxOccupants;
	}
	public void setMaxOccupants(String maxOccupants) {
		this.maxOccupants = maxOccupants;
	}
	public String getRoomDescription() {
		return roomDescription;
	}
	public void setRoomDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}
	public BigDecimal getTotalCharge() {
		return totalCharge;
	}
	public void setTotalCharge(BigDecimal totalCharge) {
		this.totalCharge = totalCharge;
	}
	public List<String> getValueAdds() {
		return valueAdds;
	}
	public void setValueAdds(List<String> valueAdds) {
		this.valueAdds = valueAdds;
	}
	public String getRemainingRooms() {
		return remainingRooms;
	}
	public void setRemainingRooms(String remainingRooms) {
		this.remainingRooms = remainingRooms;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
