package seedu.inventory.model;

import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.inventory.model.item.Item;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Item> PREDICATE_SHOW_ALL_ITEMS = unused -> true;

    /** Clears existing backing model and replaces with the provided new data. */
    void resetData(ReadOnlyInventory newData);

    /** Returns the Inventory */
    ReadOnlyInventory getInventory();

    /**
     * Returns true if a item with the same identity as {@code item} exists in the inventory book.
     */
    boolean hasItem(Item item);

    /**
     * Deletes the given item.
     * The item must exist in the inventory book.
     */
    void deleteItem(Item target);

    /**
     * Adds the given item.
     * {@code item} must not already exist in the inventory book.
     */
    void addItem(Item item);

    /**
     * Replaces the given item {@code target} with {@code editedItem}.
     * {@code target} must exist in the inventory book.
     * The item identity of {@code editedItem} must not be the same as another existing item in the inventory book.
     */
    void updateItem(Item target, Item editedItem);

    /** Returns an unmodifiable view of the filtered item list */
    ObservableList<Item> getFilteredPersonList();

    /**
     * Updates the filter of the filtered item list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredItemList(Predicate<Item> predicate);

    /**
     * Returns true if the model has previous inventory book states to restore.
     */
    boolean canUndoInventory();

    /**
     * Returns true if the model has undone inventory book states to restore.
     */
    boolean canRedoInventory();

    /**
     * Restores the model's inventory book to its previous state.
     */
    void undoInventory();

    /**
     * Restores the model's inventory book to its previously undone state.
     */
    void redoInventory();

    /**
     * Saves the current inventory book state for undo/redo.
     */
    void commitInventory();
}
