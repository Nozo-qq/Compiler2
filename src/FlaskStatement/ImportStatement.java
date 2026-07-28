package FlaskStatement;

import java.util.List;

public class ImportStatement extends Statement {
    private final List<String> packageParts;
    private final List<String> importedNames;

    public ImportStatement(int line ,List<String> packageParts, List<String> importedNames) {
        super(line);
        this.packageParts = packageParts;
        this.importedNames = importedNames;
    }

    public List<String> getPackageParts() {
        return packageParts;
    }

    public List<String> getImportedNames() {
        return importedNames;
    }

    @Override
    public List<ASTNode> getChildren() {
        return List.of();
    }
}
