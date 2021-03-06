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

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Abstract multi map based on {@link java.util.HashMap}.
 *
 * @author Philip Helger
 * @param <KEYTYPE1>
 *        outer key type
 * @param <KEYTYPE2>
 *        inner key type
 * @param <VALUETYPE>
 *        value type
 */
@NotThreadSafe
public abstract class AbstractMultiHashMapMapBased <KEYTYPE1, KEYTYPE2, VALUETYPE>
                                                   extends HashMap <KEYTYPE1, Map <KEYTYPE2, VALUETYPE>>
                                                   implements IMultiMapMapBased <KEYTYPE1, KEYTYPE2, VALUETYPE>
{
  public AbstractMultiHashMapMapBased ()
  {}

  public AbstractMultiHashMapMapBased (@Nonnull final KEYTYPE1 aKey,
                                       @Nonnull final KEYTYPE2 aInnerKey,
                                       @Nullable final VALUETYPE aValue)
  {
    putSingle (aKey, aInnerKey, aValue);
  }

  public AbstractMultiHashMapMapBased (@Nullable final KEYTYPE1 aKey, @Nullable final Map <KEYTYPE2, VALUETYPE> aValue)
  {
    put (aKey, aValue);
  }

  public AbstractMultiHashMapMapBased (@Nullable final Map <? extends KEYTYPE1, ? extends Map <KEYTYPE2, VALUETYPE>> aCont)
  {
    if (aCont != null)
      putAll (aCont);
  }

  @Nonnull
  protected abstract Map <KEYTYPE2, VALUETYPE> createNewInnerMap ();

  @Nonnull
  public Map <KEYTYPE2, VALUETYPE> getOrCreate (@Nullable final KEYTYPE1 aKey)
  {
    Map <KEYTYPE2, VALUETYPE> aCont = get (aKey);
    if (aCont == null)
    {
      aCont = createNewInnerMap ();
      super.put (aKey, aCont);
    }
    return aCont;
  }
}
