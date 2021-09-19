class Article implements Comparable<Article> {
    private String title;
    private int size;

    public Article(String title, int size) {
        this.title = title;
        this.size = size;
    }

    public String getTitle() {
        return this.title;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public int compareTo(Article otherArticle) {
        // add your code here!
        final int compareSize = Integer.compare(getSize(), otherArticle.getSize());
        if(compareSize != 0)
            return compareSize;
        else
            return getTitle().compareTo(otherArticle.getTitle());

    }
}