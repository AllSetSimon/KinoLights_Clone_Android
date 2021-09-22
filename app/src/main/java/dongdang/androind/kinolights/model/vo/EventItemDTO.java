package dongdang.androind.kinolights.model.vo;

public class EventItemDTO {

    private int id;
    private String evtTitle;
    private String evtSummary;
    private int image;
    private String evtContent;

    public EventItemDTO() {

    }

    public EventItemDTO(String evtTitle, String evtSummary, int image, String evtContent) {
        this.evtTitle = evtTitle;
        this.evtSummary = evtSummary;
        this.image = image;
        this.evtContent = evtContent;
    }

    public EventItemDTO(int id, String evtTitle, String evtSummary, int image, String evtContent) {
        this.id = id;
        this.evtTitle = evtTitle;
        this.evtSummary = evtSummary;
        this.image = image;
        this.evtContent = evtContent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEvtTitle() {
        return evtTitle;
    }

    public void setEvtTitle(String evtTitle) {
        this.evtTitle = evtTitle;
    }

    public String getEvtContent() {
        return evtContent;
    }

    public void setEvtContent(String evtContent) {
        this.evtContent = evtContent;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getEvtSummary() {
        return evtSummary;
    }

    public void setEvtSummary(String evtSummary) {
        this.evtSummary = evtSummary;
    }
}
