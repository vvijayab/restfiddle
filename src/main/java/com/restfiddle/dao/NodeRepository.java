/*
 * Copyright 2014 Ranjan Kumar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.restfiddle.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;

import com.restfiddle.entity.BaseNode;

public interface NodeRepository extends RfRepository<BaseNode, String> {

    // TODO : Also check for hasChildren.
    @Query("{ 'parentId' : ?0 }")
    public BaseNode getParent(String parentId);

    @Query("{ 'parentId' : ?0 }")
    public List<BaseNode> getChildren(String nodeId);

    @Query("{ 'projectId' : ?0 }")
    public List<BaseNode> findNodesFromAProject(String projectId);

    @Query("{ 'starred' : true }")
    public Page<BaseNode> findStarredNodes(Pageable pageable);

    @Query("{ 'tags' : ?0 }")
    public Page<BaseNode> findTaggedNodes(String tagId, Pageable pageable);

}
