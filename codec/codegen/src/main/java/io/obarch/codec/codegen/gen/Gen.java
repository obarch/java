package io.obarch.codec.codegen.gen;

public final class Gen {

    private final StringBuilder gen = new StringBuilder();
    private String indention;

    public Gen() {
        this("");
    }

    public Gen(String indention) {
        this.indention = indention;
    }

    public String indention() {
        return indention;
    }

    public void indention(String indention) {
        this.indention = indention;
    }

    public Gen __(Object obj) {
        gen.append(obj.toString());
        return this;
    }

    public Gen __(String str) {
        gen.append(str);
        return this;
    }

    public Gen __(char c) {
        gen.append(c);
        return this;
    }

    public Gen __(Line line) {
        gen.append(line.line);
        gen.append(System.lineSeparator());
        gen.append(indention);
        return this;
    }

    public Gen __(Join join) {
        for (int i = 0; i < join.objs.size(); i++) {
            if (i > 0) {
                this.__(join.separator);
            }
            Object obj = join.objs.get(i);
            this.__(join.printer.apply(obj));
        }
        return this;
    }

    public Gen __(Indent indent) {
        String oldPrefix = indention;
        indention += "  ";
        __(new Line());
        indent.op.apply();
        indention = oldPrefix;
        __(new Line());
        return this;
    }

    @Override
    public String toString() {
        return gen.toString();
    }
}
