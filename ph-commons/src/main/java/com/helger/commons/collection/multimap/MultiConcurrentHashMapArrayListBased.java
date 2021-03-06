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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

import com.helger.commons.annotation.ReturnsMutableCopy;

/**
 * Multi map based on {@link java.util.concurrent.ConcurrentHashMap} and
 * {@link ArrayList} values.<br>
 * Important note: <code>null</code> keys are not allowed here!
 *
 * @author Philip Helger
 * @param <KEYTYPE>
 *        key type
 * @param <VALUETYPE>
 *        value type
 */
@ThreadSafe
public class MultiConcurrentHashMapArrayListBased <KEYTYPE, VALUETYPE>
                                                  extends AbstractMultiConcurrentHashMapListBased <KEYTYPE, VALUETYPE>
{
  public MultiConcurrentHashMapArrayListBased ()
  {}

  public MultiConcurrentHashMapArrayListBased (@Nonnull final KEYTYPE aKey, @Nullable final VALUETYPE aValue)
  {
    super (aKey, aValue);
  }

  public MultiConcurrentHashMapArrayListBased (@Nonnull final KEYTYPE aKey, @Nonnull final List <VALUETYPE> aCollection)
  {
    super (aKey, aCollection);
  }

  public MultiConcurrentHashMapArrayListBased (@Nullable final Map <? extends KEYTYPE, ? extends List <VALUETYPE>> aCont)
  {
    super (aCont);
  }

  @Override
  @Nonnull
  @ReturnsMutableCopy
  protected final List <VALUETYPE> createNewCollection ()
  {
    return new ArrayList <VALUETYPE> ();
  }
}
