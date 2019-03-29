package com.github.supermoonie.command;

import com.github.supermoonie.annotation.*;
import com.github.supermoonie.type.dom.*;
import com.github.supermoonie.type.runtime.RemoteObject;

import java.util.List;

/**
 * This domain exposes DOM read/write operations.
 * Each DOM Node is represented with its mirror object that has an id. This id can be used to get additional information on the Node,
 * resolve it into the JavaScript object wrapper, etc.
 * It is important that client receives DOM event only for the nodes that are known to the client.
 * Backend keeps track of the nodes that were sent to the client and never sends the same node twice.
 * It is client's responsibility to collect information about the nodes that were sent to the client.
 * <p>Note that iframe owner elements will return corresponding document elements as their child nodes.</p>
 *
 * @author Administrator
 * @date 2018/9/10 0010
 */
@Domain("DOM")
public interface Dom {

    /**
     * Collects class names for the node with given id and all of it's child nodes.
     *
     * @param nodeId Id of the node to collect class names.
     * @return Class name list.
     */
    @Experimental
    @Returns("classNames")
    List<String> collectClassNamesFromSubtree(@Param("nodeId") Integer nodeId);

    /**
     * Creates a deep copy of the specified node and places it into the target container before the given anchor.
     *
     * @param nodeId             Id of the node to copy.
     * @param targetNodeId       Id of the element to drop the copy into.
     * @param insertBeforeNodeId Drop the copy before this node (if absent,
     *                           the copy becomes the last child of targetNodeId).
     * @return Id of the node clone.
     */
    @Experimental
    @Returns("nodeId")
    Integer copyTo(@Param("nodeId") Integer nodeId,
                   @Param("targetNodeId") Integer targetNodeId,
                   @Param("insertBeforeNodeId") @Optional Integer insertBeforeNodeId);

    /**
     * Describes node given its id, does not require domain to be enabled.
     * Does not start tracking any objects, can be used for automation.
     *
     * @param nodeId        Identifier of the node.
     * @param backendNodeId Identifier of the backend node.
     * @param objectId      JavaScript object id of the node wrapper.
     * @param depth         The maximum depth at which children should be retrieved,
     *                      defaults to 1. Use -1 for the entire subtree or provide an integer larger than 0.
     * @param pierce        Whether or not iframes and shadow roots should be traversed
     *                      when returning the subtree (default is false).
     * @return Node description.
     */
    @Returns("node")
    Node describeNode(@Param("nodeId") @Optional Integer nodeId,
                      @Param("backendNodeId") @Optional Integer backendNodeId,
                      @Param("objectId") @Optional String objectId,
                      @Param("depth") @Optional Integer depth,
                      @Param("pierce") @Optional Boolean pierce);

    /**
     * Disables DOM agent for the given page.
     */
    void disable();

    /**
     * Discards search results from the session with the given id.
     * getSearchResults should no longer be called for that search.
     *
     * @param searchId Unique search session identifier.
     */
    @Experimental
    void discardSearchResults(@Param("searchId") String searchId);

    /**
     * Enables DOM agent for the given page.
     */
    void enable();

    /**
     * Focuses the given element.
     *
     * @param nodeId        Identifier of the node.
     * @param backendNodeId Identifier of the backend node.
     * @param objectId      JavaScript object id of the node wrapper.
     */
    void focus(@Param("nodeId") @Optional Integer nodeId,
               @Param("backendNodeId") @Optional Integer backendNodeId,
               @Param("objectId") @Optional String objectId);

    /**
     * Returns attributes for the specified node.
     *
     * @param nodeId Id of the node to retrieve attibutes for.
     * @return An interleaved array of node attribute names and values.
     */
    @Returns("attributes")
    List<String> getAttributes(@Param("nodeId") int nodeId);

    /**
     * Returns boxes for the given node.
     *
     * @param nodeId        Identifier of the node.
     * @param backendNodeId Identifier of the backend node.
     * @param objectId      JavaScript object id of the node wrapper.
     * @return Box model for the node.
     */
    @Returns("model")
    BoxModel getBoxModel(@Param("nodeId") @Optional Integer nodeId,
                         @Param("backendNodeId") @Optional Integer backendNodeId,
                         @Param("objectId") @Optional String objectId);

    /**
     * Returns quads that describe node position on the page.
     * This method might return multiple quads for inline nodes.
     *
     * @param nodeId        Identifier of the node.
     * @param backendNodeId Identifier of the backend node.
     * @param objectId      JavaScript object id of the node wrapper.
     * @return Quads that describe node layout relative to viewport.
     */
    @Experimental
    @Returns("quads")
    List<List<Double>> getContentQuads(@Param("nodeId") @Optional Integer nodeId,
                                       @Param("backendNodeId") @Optional Integer backendNodeId,
                                       @Param("objectId") @Optional String objectId);

    /**
     * Returns the root DOM node (and optionally the subtree) to the caller.
     *
     * @param depth  The maximum depth at which children should be retrieved, defaults to 1.
     *               Use -1 for the entire subtree or provide an integer larger than 0.
     * @param pierce Whether or not iframes and shadow roots should be traversed when returning the subtree (default is false).
     * @return Resulting node.
     */
    @Returns("root")
    Node getDocument(@Optional @Param("depth") Integer depth, @Optional @Param("pierce") Boolean pierce);

    /**
     * Returns the root DOM node (and optionally the subtree) to the caller.
     *
     * @param depth  The maximum depth at which children should be retrieved, defaults to 1.
     *               Use -1 for the entire subtree or provide an integer larger than 0.
     * @param pierce Whether or not iframes and shadow roots should be traversed when returning the subtree (default is false).
     * @return Resulting node.
     */
    @Returns("nodes")
    List<Node> getFlattenedDocument(@Param("depth") @Optional Integer depth,
                                    @Param("pierce") @Optional Boolean pierce);

    /**
     * Returns node id at given location.
     * Depending on whether DOM domain is enabled, nodeId is either returned or not.
     *
     * @param x                         X coordinate.
     * @param y                         Y coordinate.
     * @param includeUserAgentShadowDOM False to skip to the nearest non-UA shadow root ancestor (default: false).
     * @return GetNodeForLocationResult
     */
    @Experimental
    GetNodeForLocationResult getNodeForLocation(@Param("x") int x,
                                                @Param("y") int y,
                                                @Param("includeUserAgentShadowDOM") @Optional Boolean includeUserAgentShadowDOM);

    /**
     * Returns node's HTML markup.
     *
     * @param nodeId        Identifier of the node.
     * @param backendNodeId Identifier of the backend node.
     * @param objectId      JavaScript object id of the node wrapper.
     * @return Outer HTML markup.
     */
    @Returns("outerHTML")
    String getOuterHTML(@Param("nodeId") @Optional Integer nodeId,
                        @Param("backendNodeId") @Optional Integer backendNodeId,
                        @Param("objectId") @Optional String objectId);

    /**
     * Returns the id of the nearest ancestor that is a relayout boundary.
     *
     * @param nodeId Id of the node.
     * @return Relayout boundary node id for the given node.
     */
    @Experimental
    @Returns("nodeId")
    Integer getRelayoutBoundary(@Param("nodeId") int nodeId);

    /**
     * Returns search results from given fromIndex to given toIndex from the search with the given identifier.
     *
     * @param searchId  Unique search session identifier.
     * @param fromIndex Start index of the search result to be returned.
     * @param toIndex   End index of the search result to be returned.
     * @return Ids of the search result nodes.
     */
    @Experimental
    @Returns("nodeIds")
    List<Integer> getSearchResults(@Param("searchId") String searchId,
                                   @Param("fromIndex") Integer fromIndex,
                                   @Param("toIndex") Integer toIndex);

    /**
     * Hides any highlight.
     */
    void hideHighlight();

    /**
     * Highlights DOM node.
     */
    void highlightNode();

    /**
     * Highlights given rectangle.
     */
    void highlightRect();

    /**
     * Marks last undoable state.
     */
    @Experimental
    void markUndoableState();

    /**
     * Moves node into the new container, places it before the given anchor.
     *
     * @param nodeId             Id of the node to move.
     * @param targetNodeId       Id of the element to drop the moved node into.
     * @param insertBeforeNodeId Drop node before this one (if absent, the moved node becomes the last child of targetNodeId).
     * @return New id of the moved node.
     */
    @Returns("nodeId")
    Integer moveTo(@Param("nodeId") int nodeId,
                   @Param("targetNodeId") int targetNodeId,
                   @Param("insertBeforeNodeId") @Optional Integer insertBeforeNodeId);

    /**
     * Searches for a given string in the DOM tree.
     * Use getSearchResults to access search results or cancelSearch to end this search session.
     *
     * @param query                     Plain text or query selector or XPath search query.
     * @param includeUserAgentShadowDOM True to search in user agent shadow DOM.
     * @return PerformSearchResult
     */
    @Experimental
    PerformSearchResult performSearch(@Param("query") String query,
                                      @Param("includeUserAgentShadowDOM") @Optional Boolean includeUserAgentShadowDOM);

    /**
     * Requests that the node is sent to the caller given its path. // FIXME, use XPath
     *
     * @param path Path to node in the proprietary format.
     * @return Id of the node for given path.
     */
    @Returns("nodeId")
    Integer pushNodeByPathToFrontend(@Param("path") String path);

    /**
     * Requests that a batch of nodes is sent to the caller given their backend node ids.
     *
     * @param backendNodeIds The array of backend node ids.
     * @return The array of ids of pushed nodes that correspond to the backend ids specified in backendNodeIds.
     */
    @Experimental
    @Returns("nodeIds")
    List<Integer> pushNodesByBackendIdsToFrontend(@Param("backendNodeIds") List<Integer> backendNodeIds);

    /**
     * Executes querySelector on a given node.
     *
     * @param nodeId   Id of the node to query upon.
     * @param selector Selector string.
     * @return Query selector result.
     */
    @Returns("nodeId")
    Integer querySelector(@Param("nodeId") int nodeId, @Param("selector") String selector);

    /**
     * Executes querySelectorAll on a given node.
     *
     * @param nodeId   Id of the node to query upon.
     * @param selector Selector string.
     * @return Query selector result.
     */
    @Returns("nodeIds")
    List<Integer> querySelectorAll(@Param("nodeId") int nodeId, @Param("selector") String selector);

    /**
     * Re-does the last undone action.
     */
    void redo();

    /**
     * Removes attribute with given name from an element with given id.
     *
     * @param nodeId Id of the element to remove attribute from.
     * @param name   Name of the attribute to remove.
     */
    void removeAttribute(@Param("nodeId") int nodeId, @Param("name") String name);

    /**
     * Removes node with given id.
     *
     * @param nodeId Id of the node to remove.
     */
    void removeNode(@Param("nodeId") int nodeId);

    /**
     * Requests that children of the node with given id are returned to the caller in form of setChildNodes events
     * where not only immediate children are retrieved, but all children down to the specified depth.
     *
     * @param nodeId Id of the node to get children for.
     * @param depth  The maximum depth at which children should be retrieved, defaults to 1.
     *               Use -1 for the entire subtree or provide an integer larger than 0.
     * @param pierce Whether or not iframes and shadow roots should be traversed when returning the sub-tree (default is false).
     */
    void requestChildNodes(@Param("nodeId") int nodeId,
                           @Param("depth") @Optional Integer depth,
                           @Param("pierce") @Optional Boolean pierce);

    /**
     * Requests that the node is sent to the caller given the JavaScript node object reference.
     * All nodes that form the path from the node to the root are also sent to the client as a series of setChildNodes notifications.
     *
     * @param objectId JavaScript object id to convert into node.
     * @return Node id for given object.
     */
    @Returns("nodeId")
    Integer requestNode(@Param("objectId") String objectId);

    /**
     * Resolves the JavaScript node object for a given NodeId or BackendNodeId.
     *
     * @param nodeId        Id of the node to resolve.
     * @param backendNodeId Backend identifier of the node to resolve.
     * @param objectGroup   Symbolic group name that can be used to release multiple objects.
     * @return JavaScript object wrapper for given node.
     */
    @Returns("object")
    RemoteObject resolveNode(@Param("nodeId") @Optional Integer nodeId,
                             @Param("backendNodeId") @Optional Integer backendNodeId,
                             @Param("objectGroup") @Optional String objectGroup);

    /**
     * Sets attribute for an element with given id.
     *
     * @param nodeId Id of the element to set attribute for.
     * @param name   Attribute name.
     * @param value  Attribute value.
     */
    void setAttributeValue(@Param("nodeId") int nodeId,
                           @Param("name") String name,
                           @Param("value") String value);

    /**
     * Sets attributes on element with given id.
     * This method is useful when user edits some existing attribute value
     * and types in several attribute name/value pairs.
     *
     * @param nodeId Id of the element to set attributes for.
     * @param text   Text with a number of attributes. Will parse this text using HTML parser.
     * @param name   Attribute name to replace with new attributes derived from text in case text parsed successfully.
     */
    void setAttributesAsText(@Param("nodeId") int nodeId,
                             @Param("text") String text,
                             @Param("name") @Optional String name);

    /**
     * Sets files for the given file input element.
     *
     * @param files         Array of file paths to set.
     * @param nodeId        Identifier of the node.
     * @param backendNodeId Identifier of the backend node.
     * @param objectId      JavaScript object id of the node wrapper.
     */
    void setFileInputFiles(@Param("files") List<String> files,
                           @Param("nodeId") @Optional Integer nodeId,
                           @Param("backendNodeId") @Optional Integer backendNodeId,
                           @Param("objectId") @Optional String objectId);

    /**
     * Enables console to refer to the node with given id via $x (see Command Line API for more details $x functions).
     *
     * @param nodeId DOM node id to be accessible by means of $x command line API.
     */
    @Experimental
    void setInspectedNode(@Param("nodeId") int nodeId);

    /**
     * Sets node name for a node with given id.
     *
     * @param nodeId Id of the node to set name for.
     * @param name   New node's name.
     * @return New node's id.
     */
    @Returns("nodeId")
    Integer setNodeName(@Param("nodeId") int nodeId, @Param("name") String name);

    /**
     * Sets node value for a node with given id.
     *
     * @param nodeId Id of the node to set value for.
     * @param value  New node's value.
     */
    void setNodeValue(@Param("nodeId") int nodeId, @Param("value") String value);

    /**
     * Sets node HTML markup, returns new node id.
     *
     * @param nodeId    Id of the node to set markup for.
     * @param outerHTML Outer HTML markup to set.
     */
    void setOuterHTML(@Param("nodeId") int nodeId, @Param("outerHTML") String outerHTML);

    /**
     * Undoes the last performed action.
     */
    @Experimental
    void undo();

    /**
     * Returns iframe node that owns iframe with the given domain.
     *
     * @param frameId Unique frame identifier.
     * @return GetFrameOwnerResult
     */
    @Experimental
    GetFrameOwnerResult getFrameOwner(@Param("frameId") String frameId);
}
