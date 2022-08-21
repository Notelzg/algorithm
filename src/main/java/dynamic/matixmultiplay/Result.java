package dynamic.matixmultiplay;

public class Result {
  // 最优解的值
  int expect;
  // 最优解的路径
  String path;

  public Result(int expect, String path) {
    this.expect = expect;
    this.path = path;
  }

  public int getExpect() {
    return expect;
  }

  public String getPath() {
    return path;
  }
}
