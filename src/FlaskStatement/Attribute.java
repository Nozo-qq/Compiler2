package FlaskStatement;

import java.util.List;

public class Attribute extends Expression{
        public  Expression object;
        public  String attribute;

        public Attribute(int line ,Expression object, String attribute) {
            super(line);
            this.object = object;
            this.attribute = attribute;
        }


    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    @Override
    public List<ASTNode> getChildren() {
        return List.of(object);
    }

}
