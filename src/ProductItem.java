class ProductItem
{
    private String category;
    private double rate;
    private String model;
    private String company;
    private String pName;
    private int productId;
    private int stackQty;

    public ProductItem(String category, double rate, String model,
                       String company, String pName, int productId, int stackQty) {
        this.category = category;
        this.rate = rate;
        this.model = model;
        this.company = company;
        this.pName = pName;
        this.productId = productId;
        this.stackQty = stackQty;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(pName);
        sb.append("(").append(model);
        sb.append(",").append(company).append(")");
        return sb.toString();
    }

    public String getCategory() {
        return category;
    }

    public double getRate() {
        return rate;
    }

    public String getModel() {
        return model;
    }

    public String getCompany() {
        return company;
    }

    public String getPName() {
        return pName;
    }

    public int getProductId() {
        return productId;
    }

    public int getStackQty() {
        return stackQty;
    }
}