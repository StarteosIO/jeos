package io.starteos.jeos.transaction;

import java.util.ArrayList;
import java.util.List;

import io.starteos.jeos.raw.Pack;
import io.starteos.jeos.raw.core.Action;

public class Transaction extends TransactionHeader implements Pack.Packer {
    private List<Action> context_free_actions;
    private List<Action> actions;
    private List<String> transaction_extensions;

    public Transaction() {
        super();
        transaction_extensions = new ArrayList<>();
        context_free_actions = new ArrayList<>();
    }

    public Transaction(Transaction other) {
        super(other);
        context_free_actions = deepCopyOnlyContainer(other.context_free_actions);
        actions = deepCopyOnlyContainer(other.actions);
        transaction_extensions = new ArrayList<>();
    }

    public void addAction(Action action) {
        if (actions == null) {
            actions = new ArrayList<>();
        }
        actions.add(action);
    }

    public void addActions(List<Action> actions) {
        if (this.actions == null) {
            this.actions = new ArrayList<>();
        }
        this.actions.addAll(actions);
    }


    protected <T> List<T> deepCopyOnlyContainer(List<T> srcList) {
        if (null == srcList) {
            return null;
        }

        List<T> newList = new ArrayList<>(srcList.size());
        newList.addAll(srcList);
        return newList;
    }

    @Override
    public void pack(Pack.Writer writer) {
        super.pack(writer);
        writer.putList(context_free_actions);
        writer.putList(actions);
        writer.putUint(transaction_extensions.size());
//        if (transaction_extensions == null) {
//            writer.putUint(0);
//        } else {
//
//        }
    }
}
