/**
 * Copyright (C) 2014-2016 Philip Helger (www.helger.com)
 * philip[at]helger[dot]com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.helger.commons.collection.multimap;

import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Abstract multi map based on {@link java.util.WeakHashMap} and
 * {@link java.util.List} values.<br>
 *
 * @author Philip Helger
 * @param <KEYTYPE>
 *        key type
 * @param <VALUETYPE>
 *        value type
 */
@NotThreadSafe
public abstract class AbstractMultiWeakHashMapListBased <KEYTYPE, VALUETYPE> extends
                                                        AbstractMultiWeakHashMap <KEYTYPE, VALUETYPE, List <VALUETYPE>>
                                                        implements IMultiMapListBased <KEYTYPE, VALUETYPE>
{
  public AbstractMultiWeakHashMapListBased ()
  {}

  public AbstractMultiWeakHashMapListBased (@Nonnull final KEYTYPE aKey, @Nullable final VALUETYPE aValue)
  {
    putSingle (aKey, aValue);
  }

  public AbstractMultiWeakHashMapListBased (@Nonnull final KEYTYPE aKey, @Nullable final List <VALUETYPE> aCollection)
  {
    put (aKey, aCollection);
  }

  public AbstractMultiWeakHashMapListBased (@Nullable final Map <? extends KEYTYPE, ? extends List <VALUETYPE>> aCont)
  {
    if (aCont != null)
      putAll (aCont);
  }
}
