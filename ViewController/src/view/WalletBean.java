package view;

import java.util.ArrayList;
import java.util.List;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.data.RichTree;
import oracle.adf.view.rich.component.rich.data.RichTreeTable;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.Key;
import oracle.jbo.uicli.binding.JUCtrlHierBinding;
import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;
import org.apache.myfaces.trinidad.model.CollectionModel;
import org.apache.myfaces.trinidad.model.RowKeySet;
import org.apache.myfaces.trinidad.model.RowKeySetImpl;


public class WalletBean {
    private RichTreeTable treeTable;

    public WalletBean() {
    }

    private RowKeySet disclosedTreeRowKeySet = new RowKeySetImpl();

    private void expandTreeTable() {
        if (this.treeTable != null) {
            disclosedTreeRowKeySet = new RowKeySetImpl();
            CollectionModel model = (CollectionModel)treeTable.getValue();
            JUCtrlHierBinding treeBinding = (JUCtrlHierBinding)model.getWrappedData();
            JUCtrlHierNodeBinding rootNode = treeBinding.getRootNodeBinding();
            disclosedTreeRowKeySet = treeTable.getDisclosedRowKeys();
            if (disclosedTreeRowKeySet == null) {
                disclosedTreeRowKeySet = new RowKeySetImpl();
            }
            List<JUCtrlHierNodeBinding> firstLevelChildren = rootNode.getChildren();
            for (JUCtrlHierNodeBinding node : firstLevelChildren) {
                ArrayList list = new ArrayList();
                list.add(node.getRowKey());
                disclosedTreeRowKeySet.add(list);
                expandTreeChildrenNode(treeTable, node, list);
            }
            treeTable.setDisclosedRowKeys(disclosedTreeRowKeySet);
        }
    }

    private void expandTreeChildrenNode(RichTreeTable rt, JUCtrlHierNodeBinding node, List<Key> parentRowKey) {
        ArrayList children = node.getChildren();
        List<Key> rowKey;
        if (children != null) {
            for (int i = 0; i < children.size(); i++) {
                rowKey = new ArrayList<Key>();
                rowKey.addAll(parentRowKey);
                rowKey.add(((JUCtrlHierNodeBinding)children.get(i)).getRowKey());
                disclosedTreeRowKeySet.add(rowKey);
                if (((JUCtrlHierNodeBinding)(children.get(i))).getChildren() == null)
                    continue;
                expandTreeChildrenNode(rt, (JUCtrlHierNodeBinding)(node.getChildren().get(i)), rowKey);
            }
        }
    }


    public void settreeTable(RichTreeTable treeTable) {
        this.treeTable = treeTable;
    }

    public RichTreeTable gettreeTable() {
        return treeTable;
    }

    public void onExpandTree(ActionEvent actionEvent) {
        this.expandTreeTable();
    }
}
